package net.pointbridge.android.sales.networkcontroller;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;

public interface NetworkEvent {
	public void onDataAvailable(final ChannelHandlerContext ctx, final MessageEvent e);
	public void onError(final ChannelHandlerContext ctx, final String message);
	public void onProcess(final String cmd, final String message);
	public void onLog(final String message);
}
