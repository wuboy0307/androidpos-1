package net.pointbridge.android.sales.networkcontroller;

import static org.jboss.netty.channel.Channels.pipeline;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
 
import org.jboss.netty.handler.codec.compression.ZlibDecoder;
import org.jboss.netty.handler.codec.compression.ZlibEncoder;
import org.jboss.netty.handler.codec.compression.ZlibWrapper;
import org.jboss.netty.handler.codec.protobuf.ProtobufDecoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufEncoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import com.pointbridge.swc3.protocol.TheProtocol;

public class ClientPipeLineFactory implements ChannelPipelineFactory {
	private final NetworkController netControl;
	public ClientPipeLineFactory(NetworkController netControl){
		this.netControl=netControl;
	}
	public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline p = pipeline();
        p.addLast("deflater", new ZlibEncoder(ZlibWrapper.GZIP));
        p.addLast("inflater", new ZlibDecoder(ZlibWrapper.GZIP));
        p.addLast("frameDecoder", new ProtobufVarint32FrameDecoder());
        p.addLast("protobufDecoder", new ProtobufDecoder(TheProtocol.TheProto.getDefaultInstance()));

        p.addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
        p.addLast("protobufEncoder", new ProtobufEncoder());
       
        p.addLast("handler", this.netControl);
        return p;
    }
}
