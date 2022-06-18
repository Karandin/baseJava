import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        for (int i = 0; i < storage.length; i++)
            if (storage[i] != null)
                storage[i] = null;
            else
                break;
    }


    void save(Resume r) {
        for (int i = 0; i < storage.length; i++)
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
    }


    Resume get(String uuid) {
        String x;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null)
                return null;

            x = storage[i].toString();
            if (x.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        String x;
        if (storage[0] == null)
            return;

        for (int i = 0; i < storage.length; i++) {
            x = storage[i].toString();
            if (x.equals(uuid)) {
                storage[i] = null;
                while (storage[i + 1] != null) {
                    storage[i] = storage[i + 1];
                    i++;
                }
                storage[i] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (int i = 0; i < storage.length; i++)
            if (storage[i] == null)
                return Arrays.copyOfRange(storage, 0, i);

        return null;
    }

    int size() {
        size = 0;
        for (Resume arr : storage) {
            if (arr == null)
                break;

            size++;
        }
        return size;
    }
}
