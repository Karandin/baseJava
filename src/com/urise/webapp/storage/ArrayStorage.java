package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;
    private int availabilyti = -1;

    public void clear() {
        System.arraycopy(storage, size, storage, 0, size);
        size = 0;
    }

    public void save(Resume r) {
        if (size > 10000) {
            System.out.println("storage заполнен, сохранение нового резюме невозможно");
            return;
        }
        check_availabilyti(r.getUuid());
        if (availabilyti != -1) {
            System.out.println("Элемент " + r + " уже есть в storage");
            availabilyti = -1;
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        check_availabilyti(uuid);
        if (availabilyti != -1) {
            int i = availabilyti;
            availabilyti = -1;
            return storage[i];
        } else {
            System.out.println("Элемента " + uuid + " нет в storage");
        }
        return null;
    }

    public void delete(String uuid) {
        check_availabilyti(uuid);
        if (availabilyti != -1) {
            size--;
            System.arraycopy(storage, availabilyti + 1, storage, availabilyti, size - availabilyti);
            availabilyti = -1;
        } else {
            System.out.println("Элемента " + uuid + " нет в storage");
        }
    }


    public void update(Resume resume) {
        check_availabilyti(resume.getUuid());
        if (availabilyti != -1) {
            System.out.println("Новое значение для " + resume);
            Scanner sc = new Scanner(System.in);
            resume.setUuid(sc.nextLine());
            storage[availabilyti] = resume;
        } else {
            System.out.println("Не фунциклирует");
        }
    }

    void check_availabilyti(String s) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(s)) {
                availabilyti = i;
                return;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
