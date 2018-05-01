package DataStructureImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FileSystem {

    static class Directory {
        private String dirName;
        private Map<String, Directory> dirs;
        private Map<String, File> files;

        Directory(String dirName) {
            this.dirName = dirName;
            this.dirs = new HashMap<>();
            this.files = new HashMap<>();
        }

        Directory getDir(String dir) {
            return dirs.get(dir);
        }

        File getFile(String file) {
            return files.get(file);
        }

        Set<String> getDirs() {
            return dirs.keySet();
        }

        Set<String> getFiles() {
            return files.keySet();
        }

        boolean isFile(String name) {
            return files.containsKey(name);
        }

        void addDir(String dir) {
            dirs.put(dir, new Directory(dir));
        }

        void addFile(String file, String content) {
            files.put(file, new File(file, content));
        }

        void appendFile(String file, String content) {
            files.get(file).append(content);
        }

        List<String> getList() {
            List<String> list = new ArrayList<>();
            list.addAll(getDirs());
            list.addAll(getFiles());
            Collections.sort(list);
            return list;
        }
    }

    static class File {
        private String fileName;
        private String fileContent;

        File(String fileName, String fileContent) {
            this.fileName = fileName;
            this.fileContent = fileContent;
        }

        void append(String fileContent) {
            this.fileContent += fileContent;
        }
    }

    private Directory root;
    public FileSystem() {
        root = new Directory("/");
    }

    public List<String> ls(String path) {
        Directory cur = root;
        String[] levels = path.split("/");

        if (levels.length == 0) {
            return cur.getList();
        }

        for (int i = 0; i < levels.length - 1; ++i) {
            if (levels[i] != null && levels[i].length() > 0) {
                cur = cur.getDir(levels[i]);
            }
        }

        String name = levels[levels.length - 1];
        if (cur.isFile(name)) {
            return Collections.singletonList(name);
        }

        return cur.getDir(name).getList();
    }

    public void mkdir(String path) {
        Directory cur = root;
        String[] levels = path.split("/");
        for (String level : levels) {
            if (level != null && level.length() > 0) {
                if (!cur.getDirs().contains(level)) {
                    cur.addDir(level);
                }
                cur = cur.getDir(level);
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        Directory cur = root;
        String[] levels = filePath.split("/");
        for (int i = 0; i < levels.length - 1; ++i) {
            if (levels[i] != null && levels[i].length() > 0) {
                cur = cur.getDir(levels[i]);
            }
        }

        String fileName = levels[levels.length - 1];
        if (cur.getFiles().contains(fileName)) {
            cur.appendFile(fileName, content);
        } else {
            cur.addFile(fileName, content);
        }
    }

    public String readContentFromFile(String filePath) {
        Directory cur = root;
        String[] levels = filePath.split("/");
        for (int i = 0; i < levels.length - 1; ++i) {
            if (levels[i] != null && levels[i].length() > 0) {
                cur = cur.getDir(levels[i]);
            }
        }
        return cur.getFile(levels[levels.length - 1]).fileContent;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        System.out.println(fs.ls("/"));
        fs.mkdir("/a/b/c");
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/z", "Doomed!");
        fs.mkdir("/goowmfn");
        System.out.println(fs.ls("/"));
        System.out.println(fs.ls("/z"));
        System.out.println(fs.ls("/goowmfn"));
        fs.addContentToFile("/a/b/c/d", "Hello");
        fs.addContentToFile("/goowmfn/c", "shetopcy");
        System.out.println(fs.ls("/goowmfn/c"));
        System.out.println(fs.ls("/goowmfn"));
        System.out.println(fs.ls("/a/b/c/d"));
        System.out.println(fs.ls("/a/b/c"));
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
        fs.addContentToFile("/a/b/c/d", " World!");
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
    }
}
