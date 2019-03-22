package DataStructureImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DesignInMemoryFileSystem {

	private Directory root;

	public DesignInMemoryFileSystem() {
		root = new Directory("/");
	}

	public static void main(String[] args) {
		DesignInMemoryFileSystem fileSystem = new DesignInMemoryFileSystem();
		System.out.println(fileSystem.ls("/"));
		fileSystem.mkdir("/a/b/c");
		System.out.println(fileSystem.ls("/"));
		System.out.println(fileSystem.ls("/a/b/c"));
		fileSystem.addContentToFile("/a/b/c/cce", "hello");
		System.out.println(fileSystem.readContentFromFile("/a/b/c/cce"));
		fileSystem.addContentToFile("/a/b/c/cce", "world");
		System.out.println(fileSystem.readContentFromFile("/a/b/c/cce"));
		fileSystem.mkdir("/a/b/c/d");
		System.out.println(fileSystem.ls("/a/b/c"));
		fileSystem.addContentToFile("/bne", "kvo");
		System.out.println(fileSystem.ls("/"));
		System.out.println(fileSystem.readContentFromFile("/bne"));
	}

	public List<String> ls(String path) {
		Directory cur = root;
		String[] parts = path.split("/");

		for (int i = 1; i < parts.length - 1; ++i) {
			cur = cur.dirs.get(parts[i]);
		}

		if (parts.length == 0) {
			Set<String> contents = new TreeSet<>(cur.dirs.keySet());
			contents.addAll(cur.files.keySet());
			return new ArrayList<>(contents);
		}

		if (cur.files.containsKey(parts[parts.length - 1])) {
			return Collections.singletonList(parts[parts.length - 1]);
		}

		Set<String> contents = new TreeSet<>(cur.dirs.get(parts[parts.length - 1]).dirs.keySet());
		contents.addAll(cur.dirs.get(parts[parts.length - 1]).files.keySet());
		return new ArrayList<>(contents);
	}

	public void mkdir(String path) {
		Directory cur = root;
		String[] parts = path.split("/");
		Directory temp;

		for (int i = 1; i < parts.length; ++i) {
			if (!cur.dirs.containsKey(parts[i])) {
				temp = new Directory(parts[i]);
				cur.dirs.put(parts[i], temp);
			}
			cur = cur.dirs.get(parts[i]);
		}
	}

	public void addContentToFile(String path, String content) {
		File f = getFile(path);
		f.content += content;
	}

	public String readContentFromFile(String path) {
		return getFile(path).content;
	}

	File getFile(String path) {
		Directory cur = root;
		String[] parts = path.split("/");

		for (int i = 1; i < parts.length - 1; ++i) {
			cur = cur.dirs.get(parts[i]);
		}

		if (!cur.files.containsKey(parts[parts.length - 1])) {
			cur.files.put(parts[parts.length - 1], new File(parts[parts.length - 1]));
		}
		return cur.files.get(parts[parts.length - 1]);
	}

	class Directory {
		String name;
		Map<String, Directory> dirs;
		Map<String, File> files;

		Directory(String name) {
			this.name = name;
			dirs = new HashMap<>();
			files = new HashMap<>();
		}
	}

	class File {
		String name;
		String content;

		public File(String name) {
			this.name = name;
			content = "";
		}
	}
}