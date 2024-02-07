package Homework_15_01_2024.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final Path dir;

    public EncryptedClassLoader(String key, Path dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            Path fullPath = dir.resolve(name.replace('.', File.separatorChar));
            byte[] classBytes = Files.readAllBytes(fullPath);
            decode(classBytes);

            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException | ClassFormatError e) {
            throw new ClassNotFoundException("Failed to load class: " + name, e);
        }
    }

    private void decode(byte[] encoded) {
        byte delta = (byte) key.length();

        for (var i = 0; i < encoded.length; ++i)
            encoded[i] += delta;
    }
}