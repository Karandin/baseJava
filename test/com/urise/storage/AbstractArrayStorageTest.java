package com.urise.storage;

import model.Resume;
import storage.Storage;
import storage.exception.StorageException;
import org.junit.jupiter.api.Test;

import static storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
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
