/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/michael/Work/SWC3/AndroidSales/theclient/android/src/net/pointbridge/android/sales/plugin/backgroundservice/BackgroundServiceApi.aidl
 */
package net.pointbridge.android.sales.plugin.backgroundservice;
public interface BackgroundServiceApi extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi
{
private static final java.lang.String DESCRIPTOR = "net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi interface,
 * generating a proxy if needed.
 */
public static net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi))) {
return ((net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi)iin);
}
return new net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getLatestResult:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getLatestResult();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_addListener:
{
data.enforceInterface(DESCRIPTOR);
net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener _arg0;
_arg0 = net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener.Stub.asInterface(data.readStrongBinder());
this.addListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeListener:
{
data.enforceInterface(DESCRIPTOR);
net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener _arg0;
_arg0 = net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener.Stub.asInterface(data.readStrongBinder());
this.removeListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isTimerEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isTimerEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enableTimer:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.enableTimer(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_disableTimer:
{
data.enforceInterface(DESCRIPTOR);
this.disableTimer();
reply.writeNoException();
return true;
}
case TRANSACTION_getConfiguration:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getConfiguration();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setConfiguration:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setConfiguration(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_askJob:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.askJob(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceApi
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String getLatestResult() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLatestResult, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void addListener(net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeListener(net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isTimerEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isTimerEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void enableTimer(int milliseconds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(milliseconds);
mRemote.transact(Stub.TRANSACTION_enableTimer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void disableTimer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disableTimer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getConfiguration() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConfiguration, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setConfiguration(java.lang.String configuration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(configuration);
mRemote.transact(Stub.TRANSACTION_setConfiguration, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String askJob(java.lang.String configuration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(configuration);
mRemote.transact(Stub.TRANSACTION_askJob, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getLatestResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_addListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_removeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_isTimerEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_enableTimer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_disableTimer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_setConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_askJob = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
}
public java.lang.String getLatestResult() throws android.os.RemoteException;
public void addListener(net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener listener) throws android.os.RemoteException;
public void removeListener(net.pointbridge.android.sales.plugin.backgroundservice.BackgroundServiceListener listener) throws android.os.RemoteException;
public boolean isTimerEnabled() throws android.os.RemoteException;
public void enableTimer(int milliseconds) throws android.os.RemoteException;
public void disableTimer() throws android.os.RemoteException;
public java.lang.String getConfiguration() throws android.os.RemoteException;
public void setConfiguration(java.lang.String configuration) throws android.os.RemoteException;
public java.lang.String askJob(java.lang.String configuration) throws android.os.RemoteException;
}
