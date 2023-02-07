package me.gv7.woodpecker.plugin;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Map;

public class Convert implements IHelper {
    public IResultOutput iResultOutput = null;
    @Override
    public String getHelperTabCaption() {
        return "commonsFileupload Convert";
    }

    @Override
    public IArgsUsageBinder getHelperCutomArgs() {
        IArgsUsageBinder argsUsageBinder = HelperPluginInfo.pluginHelper.createArgsUsageBinder();
        ArrayList<IArg> args = new ArrayList<>();
        IArg arg = HelperPluginInfo.pluginHelper.createArg();
        arg.setName("args");
        arg.setDefaultValue("1.jsp");
        arg.setDescription("设置要转换的数据");
        arg.setRequired(true);
        args.add(arg);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    @Override
    public void doHelp(Map<String, Object> map, IResultOutput iResultOutput) throws Throwable {
        this.iResultOutput = iResultOutput;
        String text = (String) map.get("args");
        encode(text);
    }

    public  void encode(String encodeName){
        /*
        utf-8?B就是base64编码
        gbk?Q就是Quoted-printable编码
         */
        byte[] encode = encodeName.getBytes(StandardCharsets.UTF_8);
        byte[] b = Base64.getEncoder().encode(encode);

        this.iResultOutput.infoPrintln("############[" + encodeName + "]############");
        this.iResultOutput.infoPrintln("***base64:");
        this.iResultOutput.infoPrintln("=?utf-8?B?" + new String(b, StandardCharsets.UTF_8) + "?=");

        StringBuilder res = new StringBuilder();
        for (byte c : encodeName.getBytes(StandardCharsets.UTF_8)) {
            String tmp = Integer.toHexString(c);
            res.append("=").append(tmp);
        }
        
        this.iResultOutput.infoPrintln("***Quoted-printable:");
        this.iResultOutput.infoPrintln("=?gbk?Q?" + res + "?=");
        this.iResultOutput.infoPrintln("############[" + encodeName + "]############");
        this.iResultOutput.infoPrintln("utf-8?B就是base64编码");
        this.iResultOutput.infoPrintln("gbk?Q就是Quoted-printable编码");
    }
}
