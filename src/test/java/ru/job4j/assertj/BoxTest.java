package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class BoxTest {

    @Test
    void whenVertex0AndEdge5ThenSphereExists() {
        Box box = new Box(0, 5);
        assertThat(box).extracting(Box::whatsThis, Box::isExist)
                .containsExactly("Sphere", true);
    }

    @Test
    void whenVertex0AndEdgeNegativeThenUnknown() {
        Box box = new Box(0, -1);
        assertThat(box).extracting(Box::whatsThis, Box::isExist, Box::getNumberOfVertices)
                .containsExactly("Unknown object", false, -1);
    }

    @Test
    void whenVertex4AndEdge10ThenTetrahedronExists() {
        Box box = new Box(4, 10);
        assertThat(box).extracting(Box::whatsThis, Box::isExist, Box::getNumberOfVertices)
                .containsExactly("Tetrahedron", true, 4);
    }

    @Test
    void whenVertex4AndEdge0ThenUnknown() {
        Box box = new Box(4, 0);
        assertThat(box).extracting(Box::whatsThis, Box::isExist, Box::getNumberOfVertices)
                .containsExactly("Unknown object", false, -1);
    }

    @Test
    void whenVertex8AndEdge2ThenCubeExists() {
        Box box = new Box(8, 2);
        assertThat(box).extracting(Box::whatsThis, Box::isExist, Box::getNumberOfVertices)
                .containsExactly("Cube", true, 8);
    }

    @Test
    void whenVertex8AndEdgeNegativeThenUnknown() {
        Box box = new Box(8, -5);
        assertThat(box).extracting(Box::whatsThis, Box::isExist, Box::getNumberOfVertices)
                .containsExactly("Unknown object", false, -1);
    }

    @Test
    void whenSphereAreaWithEdge3() {
        Box box = new Box(0, 3);
        assertThat(box.getArea()).isCloseTo(113.097, within(0.001));
    }

    @Test
    void whenSphereAreaWithEdgeNegative() {
        Box box = new Box(0, -3);
        assertThat(box.getArea()).isEqualTo(0);
    }

    @Test
    void whenTetrahedronAreaWithEdge4() {
        Box box = new Box(4, 4);
        assertThat(box.getArea()).isCloseTo(27.7128, within(0.0001));
    }

    @Test
    void whenCubeAreaWithEdge2() {
        Box box = new Box(8, 2);
        assertThat(box.getArea()).isEqualTo(24);
    }

    @Test
    void whenUnknownTypeArea() {
        Box box = new Box(7, 3);
        assertThat(box.getArea()).isEqualTo(0);
    }

    @Test
    void whenCubeAreaWithEdgeNegative() {
        Box box = new Box(8, -1);
        assertThat(box.getArea()).isEqualTo(0);
    }
}