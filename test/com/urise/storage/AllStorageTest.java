package com.urise.storage;

import java.util.List;

@RunWith(Suite.class)
@Suite.SuiteClasses (
        {
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                ListStorageTest.class,
                MapStorageTest.class,
        })
public class AllStorageTest {
}
