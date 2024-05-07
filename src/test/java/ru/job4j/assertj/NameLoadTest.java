package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void whenEmptyNamesArrayThenException() {
        NameLoad loader = new NameLoad();
        assertThatThrownBy(() -> loader.parse())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Names array is empty");
    }

    @Test
    void whenNameDoesNotContainEqualSignThenException() {
        NameLoad loader = new NameLoad();
        String input = "keyvalue";
        assertThatThrownBy(() -> loader.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain the symbol '='")
                .hasMessageContaining(input);
    }

    @Test
    void whenNameStartsWithEqualThenException() {
        NameLoad loader = new NameLoad();
        String input = "=value";
        assertThatThrownBy(() -> loader.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key")
                .hasMessageContaining(input);
    }

    @Test
    void whenNameEndsWithEqualThenException() {
        NameLoad loader = new NameLoad();
        String input = "key=";
        assertThatThrownBy(() -> loader.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value")
                .hasMessageContaining(input);
    }

    @Test
    void whenGetMapOnEmptyMapThenException() {
        NameLoad loader = new NameLoad();
        assertThatThrownBy(loader::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("collection contains no data");
    }
}