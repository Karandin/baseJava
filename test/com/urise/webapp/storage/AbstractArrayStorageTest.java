package com.urise.webapp.storage;

import model.Resume;
import model.storage.Storage;
import model.storage.exception.StorageException;
import org.junit.jupiter.api.Test;

import static model.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbstractArrayStorageTest extends AbstractStorageTest{
    private final Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Test
    public void storageOverflow() {
        storage.clear();
        for (int i = 0; i < STORAGE_LIMIT; i++) {
            storage.save(new Resume("dummy"));
        }
        assertThrows(StorageException.class, () -> storage.save(new Resume("dummy")));
    }
}
