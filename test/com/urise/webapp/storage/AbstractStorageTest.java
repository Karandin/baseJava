package com.urise.webapp.storage;

import model.Resume;
import model.storage.exception.ExistStorageException;
import model.storage.exception.NotExistStorageException;
import model.storage.exception.StorageException;
import model.storage.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_NOT_EXIST = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    protected Storage storage;
    // private Storage storage = new ArrayStorage();


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    private void assertGet(Resume resume) {
        assertSame(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    @Test
    public void update() {
        Resume updated = new Resume(UUID_1);
        storage.update(updated);
        assertSame(updated, storage.get(UUID_1));
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    public void saveExist() {
        assertThrows(ExistStorageException.class, () -> storage.save(RESUME_1));
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    public void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_NOT_EXIST));
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_1));
    }

    @Test
    public void deleteNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_NOT_EXIST));
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void getAllSorted() {
        Resume[] expected = {RESUME_1, RESUME_2, RESUME_3};
        Resume[] actual = storage.getAllSorted().toArray(new Resume[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void size() {
        assertSize(3);
    }
    /*
    @Test
    public void storageOverflow() {
        storage.clear();
        for (int i = 0; i < STORAGE_LIMIT; i++) {
            storage.save(new Resume("dummy"));
        }
        assertThrows(StorageException.class, () -> storage.save(new Resume("dummy")));
    }

     */
}