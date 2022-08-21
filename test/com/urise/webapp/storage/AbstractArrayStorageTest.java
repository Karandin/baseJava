package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import exception.NotExistStorageException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static Resume r1 = new Resume(UUID_1);
    private static Resume r2 = new Resume(UUID_2);
    private static Resume r3 = new Resume(UUID_3);
    private static Resume r4 = new Resume(UUID_4);
    private final Storage storage;
    // private Storage storage = new ArrayStorage();


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(r1);
        storage.save(r2);
        storage.save(r3);
    }

    @Test
    public void update() {
        storage.update(r1);
        Assert.assertEquals(UUID_1, r1.getUuid());
    }

    @Test
    public void save() {
        storage.save(r4);
        Assert.assertEquals(4, storage.size());
    }

    @Test
    public void get() {
        storage.get("uuid1");
        Assert.assertEquals("uuid1", r1.getUuid());
        storage.get("uuid2");
        Assert.assertEquals("uuid2", r2.getUuid());
        storage.get("uuid3");
        Assert.assertEquals("uuid3", r3.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("notExistResume");
    }

    @Test
    public void delete() {
        storage.delete("uuid1");
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        storage.getAll();
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }
}