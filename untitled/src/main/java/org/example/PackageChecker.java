package org.example;

import org.example.exceptions.PackageException;

public class PackageChecker {

    private final Object object;
    private final String packageName;

    public PackageChecker(String packageName, Object object) {
        this.object = object;
        this.packageName = packageName;
    }

    public boolean checked() {
        try {
            Class<?> clazz = object.getClass();
            String actualPackageName = clazz.getPackage().getName();
            return packageName.equals(actualPackageName);
        } catch (Exception e) {
            throw new PackageException("Ошибка при проверке принадлежности к пакету.", e);
        }
    }
}
