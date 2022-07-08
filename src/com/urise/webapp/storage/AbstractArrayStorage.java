package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < size) {
            System.out.println(storage[index] + " теперь имеет значение " + resume.getUuid());
            storage[index] = resume;
        } else {
            System.out.println("Элементa " + resume + " нет в storage");
        }
    }

    public void save(Resume r) {
        if (size == STORAGE_LIMIT) {
            System.out.println("storage заполнен, сохранение нового резюме невозможно");
        } else if (size == 0) {
            storage[0] = r;
            size++;
        } else {
            saveValue(r);
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < size) {
            return storage[index];
        }
        System.out.println("Resume " + uuid + " not exist");
        return null;
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index > size) {
            System.out.println("Элемента " + uuid + " нет в storage");
        } else {
            deleteValue(uuid);
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int findIndex(String uuid);

    protected abstract void saveValue(Resume r);

    protected abstract void deleteValue(String uuid);


}

