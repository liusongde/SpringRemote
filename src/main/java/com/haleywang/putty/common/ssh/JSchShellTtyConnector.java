package com.haleywang.putty.common.ssh;

import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class JSchShellTtyConnector extends JSchTtyConnector<ChannelShell> {

    public JSchShellTtyConnector() {
    }

    public JSchShellTtyConnector(String host, String user, String password) {
        super(host, DEFAULT_PORT, user, password);
    }

    public JSchShellTtyConnector(String host, int port, String user, String password) {
        super(host, port, user, password);
    }

    @Override
    public ChannelShell openChannel(Session session) throws JSchException {
        return (ChannelShell) session.openChannel("shell");
    }

    @Override
    public void configureChannelShell(ChannelShell channel) {
        String lang = System.getenv().get("LANG");
        channel.setEnv("LANG", lang != null ? lang : "en_US.UTF-8");
        channel.setPtyType("xterm");
    }

    @Override
    protected void setPtySize(ChannelShell channel, int col, int row, int wp, int hp) {
        channel.setPtySize(col, row, wp, hp);
    }

}
