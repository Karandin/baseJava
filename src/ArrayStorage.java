import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (i < 10000) {
            if (storage[i] != null) {
                storage[i] = null;
                i++;
            } else
                break;
        }
    }

    void save(Resume r) {
        int i = 0;
        while (i < 10000) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            } else
                i++;
        }
    }

    // Если честно, не совсем понял про get "dummy". Насколько я понял нужно просто вернуть "dummy" ¯\_(ツ)_/¯ .
    Resume get(String uuid) {
        int i = 0;
        String x;
        while (true && i < storage.length) {
            if (storage[i] == null) {
                Resume r = new Resume();
                r.uuid = uuid;
                return r;
            }
            x = storage[i].toString();
            if (x.equals(uuid))
                break;
            else
                i++;
        }
        return storage[i];
    }

    void delete(String uuid) {
        int i = 0;
        String x;
        if (storage[i] == null)
            return;

        while (i < 10000) {
            x = storage[i].toString();
            if (x.equals(uuid)) {
                storage[i] = null;
                while (storage[i + 1] != null) {
                    storage[i] = storage[i + 1];
                    i++;
                }
                storage[i] = null;
                break;
            } else
                i++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int i = 0;
        while (i < 10000) {
            if (storage[i] == null) {
                break;
            } else
                i++;
        }
        return Arrays.copyOfRange(storage, 0, i);
    }

    int size() {
        int i = 0;
        while (i < 10000) {
            if (storage[i] == null) {
                break;
            } else
                i++;
        }
        return i;
    }
}
