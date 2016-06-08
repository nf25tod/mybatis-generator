package com.nextxworkroom.mybatis;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.ShellRunner;

import java.io.File;

/**
 * Created by lscm on 16/6/8.
 */
public class generator {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"resource:generator-payGateway.xml"};
        }
        if (args.length == 1 && StringUtils.isNotBlank(args[0])) {
            String configFile = args[0];
            if (configFile.startsWith("\\") || configFile.startsWith("/")) { //Linux绝对路径

            } else if (configFile.length() > 2 && configFile.charAt(1) == ':') { //Windows绝对路径

            } else if (configFile.startsWith("resource:")) {
                configFile = new File("").getAbsolutePath() + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + configFile.replace("resource:", "");
            } else {
                configFile = new File("").getAbsolutePath() + File.separator + configFile;
            }
            System.out.println("使用配置文件:" + configFile);
            ShellRunner.main(new String[]{"-overwrite", "-verbose", "-configfile", configFile});
        } else {
            ShellRunner.main(args);
        }
    }
}
