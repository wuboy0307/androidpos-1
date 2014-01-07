package net.pointbridge.android.sales;

import java.text.DateFormat;
import java.util.Date;

import net.pointbridge.android.sales.db.Config;
import net.pointbridge.android.sales.db.ConfigDao;
import net.pointbridge.android.sales.db.DaoMaster;
import net.pointbridge.android.sales.db.DaoMaster.DevOpenHelper;
import net.pointbridge.android.sales.db.DaoSession;
import net.pointbridge.android.sales.R;
import net.pointbridge.android.sales.R.id;
import net.pointbridge.android.sales.R.layout;
import net.pointbridge.android.sales.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class TestActivity extends ListActivity {
	 private EditText editText;
	private SQLiteDatabase db;
   

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private ConfigDao configDao;

    private Cursor cursor;

	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
	 
			super.onCreate(savedInstanceState);

	        setContentView(R.layout.activity_test);

	        DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "test-db2", null);
	        db = helper.getWritableDatabase();
	        daoMaster = new DaoMaster(db);
	        daoSession = daoMaster.newSession();
	        configDao = daoSession.getConfigDao();

	        String textColumn = ConfigDao.Properties.Conf_name.columnName;
	        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
	        cursor = db.query(configDao.getTablename(), configDao.getAllColumns(), null, null, null, null, orderBy);
	        String[] from = { textColumn,ConfigDao.Properties.Conf_note.columnName };
	        int[] to = { android.R.id.text1, android.R.id.text2 };

	        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from,
	                to);
	        setListAdapter(adapter);

	        editText = (EditText) findViewById(R.id.editTextNote);
	        addUiListeners();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}protected void addUiListeners() {
        editText.setOnEditorActionListener(new OnEditorActionListener() {
 
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				   if (actionId == EditorInfo.IME_ACTION_DONE) {
	                    addNote();
	                    return true;
	                }
	                return false;
			}
        });

        final View button = findViewById(R.id.buttonAdd);
        button.setEnabled(false);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean enable = s.length() != 0;
                button.setEnabled(enable);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

             
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
        });
    }

    public void onMyButtonClick(View view) {
        addNote();
    }

    private void addNote() {
        String noteText = editText.getText().toString();
        editText.setText("");

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());
        Config config = new Config(null,"test",comment,noteText); 
        configDao.insert(config);
        Log.d("DaoExample", "Inserted new config, ID: " + config.getConf_name());

        cursor.requery();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
  	configDao.deleteByKey(id);
        Log.d("DaoExample", "Deleted note, ID: " + id);
        cursor.requery();
    }

}
