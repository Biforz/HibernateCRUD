package org.example.repository.hibernate;

import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.example.service.LabelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class HibernateLabelRepositoryImplTest {
    private final LabelRepository labelRepository = Mockito.mock(LabelRepository.class);
    private final LabelService labelService = new LabelService(labelRepository);
    private Label label;

    @BeforeEach
    void setUp() {
        label = Label.builder()
                .id(1L)
                .name("testName")
                .build();
    }

    @Test
    void getAllLabel() {
        List<Label> labels = new ArrayList<>();
        labels.add(label);

        when(labelService.findAllLabels()).thenReturn(labels);

        List<Label> labelsActualList = labelService.findAllLabels();

        assertNotNull(labelsActualList);
        assertEquals(labels, labelsActualList);
    }

    @Test
    void getLabelById() {
        when(labelService.findById(1L)).thenReturn(label);

        Label actualLabel = labelService.findById(1L);

        assertNotNull(actualLabel);
        assertEquals(actualLabel.getId(), label.getId());
        assertEquals(actualLabel.getName(), label.getName());
    }

    @Test
    void createdNewLabel() {
        when(labelService.addNewLabel(label)).thenReturn(label);

        Label actualLabel = labelService.addNewLabel(label);

        assertNotNull(actualLabel);
        assertEquals(actualLabel.getId(), label.getId());
        assertEquals(actualLabel.getName(), label.getName());
    }

    @Test
    void updatedLabel() {
        when(labelService.updatedLabel(1L, label)).thenReturn(label);

        Label actualLabel = labelService.updatedLabel(1L, label);

        assertNotNull(actualLabel);
        assertEquals(actualLabel.getId(), label.getId());
        assertEquals(actualLabel.getName(), label.getName());
    }

    @Test
    void deleteLabel() {
        labelService.deleteLabelById(1L);
        verify(labelRepository, times(1)).deleteById(1L);
    }
}
