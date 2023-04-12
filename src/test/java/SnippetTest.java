import org.candidatestest.SnippetRefactoring;
import org.candidatestest.SnippetRefactoring.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SnippetTest {
    private SnippetRefactoring snippetRef;

    @BeforeEach
    void setUp() {
        snippetRef = new SnippetRefactoring();
    }

    @Test
    void updateWithValidData() {
        List<Data> data = Arrays.asList(
                createData(true, "test", 1, 1),
                createData(true, "test", 2, 2),
                createData(false, "test", 3, 3),
                createData(true, "test", 4, 4),
                createData(true, "default", 1, 5),
                createData(false, "default", 2, 6)
        );

        boolean result = snippetRef.update(data, "test");
        assertTrue(result, "Update should return true with valid data");
    }

    @Test
    void updateWithInvalidData() {
        List<Data> data = Arrays.asList(
                createData(false, "test", 1, 1),
                createData(false, "test", 2, 2),
                createData(false, "default", 1, 3),
                createData(false, "default", 2, 4)
        );

        boolean result = snippetRef.update(data, "test");
        assertFalse(result, "Update should return false with invalid data");
    }

    @Test
    void updateWithEmptyData() {
        List<Data> data = List.of();

        boolean result = snippetRef.update(data, "test");
        assertFalse(result, "Update should return false with empty data");
    }

    private Data createData(boolean flag, String label, int value, int id) {
        Data data = new Data();
        data.flag = flag;
        data.label = label;
        data.value = value;
        data.id = id;
        return data;
    }
}