package at.favre.tools.apksigner.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * The model for the passed arguments
 */
public class Arg {
    public String apkFile;
    public String out;

    public List<SignArgs> signArgsList = new ArrayList<>();

    public boolean overwrite = false;
    public boolean dryRun = false;
    public boolean verbose = false;
    public boolean skipZipAlign = false;
    public boolean debug = false;
    public boolean onlyVerify = false;
    public boolean ksIsDebug = false;

    public String zipAlignPath;

    Arg() {
    }

    Arg(String apkFile, String out, List<SignArgs> list,
        boolean overwrite, boolean dryRun, boolean verbose, boolean skipZipAlign, boolean debug, boolean onlyVerify,
        String zipAlignPath, boolean ksIsDebug) {
        this.apkFile = apkFile;
        this.out = out;
        this.signArgsList = list;
        this.overwrite = overwrite;
        this.dryRun = dryRun;
        this.verbose = verbose;
        this.skipZipAlign = skipZipAlign;
        this.debug = debug;
        this.onlyVerify = onlyVerify;
        this.zipAlignPath = zipAlignPath;
        this.ksIsDebug = ksIsDebug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Arg arg = (Arg) o;

        if (overwrite != arg.overwrite) return false;
        if (dryRun != arg.dryRun) return false;
        if (verbose != arg.verbose) return false;
        if (skipZipAlign != arg.skipZipAlign) return false;
        if (debug != arg.debug) return false;
        if (onlyVerify != arg.onlyVerify) return false;
        if (ksIsDebug != arg.ksIsDebug) return false;
        if (apkFile != null ? !apkFile.equals(arg.apkFile) : arg.apkFile != null) return false;
        if (out != null ? !out.equals(arg.out) : arg.out != null) return false;
        if (signArgsList != null ? !signArgsList.equals(arg.signArgsList) : arg.signArgsList != null) return false;
        if (zipAlignPath != null ? !zipAlignPath.equals(arg.zipAlignPath) : arg.zipAlignPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = apkFile != null ? apkFile.hashCode() : 0;
        result = 31 * result + (out != null ? out.hashCode() : 0);
        result = 31 * result + (signArgsList != null ? signArgsList.hashCode() : 0);
        result = 31 * result + (overwrite ? 1 : 0);
        result = 31 * result + (dryRun ? 1 : 0);
        result = 31 * result + (verbose ? 1 : 0);
        result = 31 * result + (skipZipAlign ? 1 : 0);
        result = 31 * result + (debug ? 1 : 0);
        result = 31 * result + (onlyVerify ? 1 : 0);
        result = 31 * result + (ksIsDebug ? 1 : 0);
        result = 31 * result + (zipAlignPath != null ? zipAlignPath.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Arg{" +
                "apkFile='" + apkFile + '\'' +
                ", out='" + out + '\'' +
                ", signArgsList=" + signArgsList +
                ", overwrite=" + overwrite +
                ", dryRun=" + dryRun +
                ", verbose=" + verbose +
                ", skipZipAlign=" + skipZipAlign +
                ", debug=" + debug +
                ", onlyVerify=" + onlyVerify +
                ", ksIsDebug=" + ksIsDebug +
                ", zipAlignPath='" + zipAlignPath + '\'' +
                '}';
    }

    public static class SignArgs implements Comparable<SignArgs> {
        public int index;
        public String ksFile;
        public String alias;
        public String pass;
        public String keyPass;

        SignArgs(int index, String ksFile, String alias, String pass, String keyPass) {
            this.index = index;
            this.ksFile = ksFile;
            this.alias = alias;
            this.pass = pass;
            this.keyPass = keyPass;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SignArgs signArgs = (SignArgs) o;

            if (index != signArgs.index) return false;
            if (ksFile != null ? !ksFile.equals(signArgs.ksFile) : signArgs.ksFile != null) return false;
            if (alias != null ? !alias.equals(signArgs.alias) : signArgs.alias != null) return false;
            if (pass != null ? !pass.equals(signArgs.pass) : signArgs.pass != null) return false;
            return keyPass != null ? keyPass.equals(signArgs.keyPass) : signArgs.keyPass == null;

        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + (ksFile != null ? ksFile.hashCode() : 0);
            result = 31 * result + (alias != null ? alias.hashCode() : 0);
            result = 31 * result + (pass != null ? pass.hashCode() : 0);
            result = 31 * result + (keyPass != null ? keyPass.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "SignArgs{" +
                    "index=" + index +
                    ", ksFile='" + ksFile + '\'' +
                    ", alias='" + alias + '\'' +
                    ", pass='" + pass + '\'' +
                    ", keyPass='" + keyPass + '\'' +
                    '}';
        }

        @Override
        public int compareTo(SignArgs o) {
            return Integer.valueOf(index).compareTo(o.index);
        }
    }
}
