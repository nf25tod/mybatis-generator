package org.mybatis.generator.api;

import java.io.File;

/**
 * Created by lscm on 16/6/8.
 */
public abstract class GeneratedFile {

    protected String targetProject;

    public GeneratedFile(String targetProject) {
        super();
        if (targetProject.equalsIgnoreCase("${targetProject}")) {
            this.targetProject = new File("").getAbsolutePath();
            targetProject = new File(this.targetProject + File.separator + "src"
                    + File.separator + "main" + File.separator + "java").exists() ?
                    this.targetProject + File.separator + "src" + File.separator + "main" + File.separator + "java"
                    : this.targetProject;
        }
        this.targetProject = targetProject;

    }

    public abstract String getFormattedContent();

    public abstract String getFileName();

    public String getTargetProject() {
        return targetProject;
    }

    public abstract String getTargetPackage();

    public String toString() {
        return getFormattedContent();
    }

    public abstract boolean isMergeable();
}
