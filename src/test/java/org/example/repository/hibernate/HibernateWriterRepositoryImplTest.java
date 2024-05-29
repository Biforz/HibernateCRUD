package org.example.repository.hibernate;

import org.example.model.Writer;
import org.example.repository.WriterRepository;
import org.example.service.WriterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class HibernateWriterRepositoryImplTest {
    private final WriterRepository writerRepository = Mockito.mock(WriterRepository.class);
    private final WriterService writerService = new WriterService(writerRepository);
    private Writer writer;

    @BeforeEach
    void setUp() {
        writer = Writer.builder()
                .id(1L)
                .firstname("testFirstName")
                .lastname("testLastName")
                .build();
    }

    @Test
    void getAllWriter() {
        List<Writer> writers = new ArrayList<>();
        writers.add(writer);

        when(writerService.findAllWriter()).thenReturn(writers);

        List<Writer> actualList = writerService.findAllWriter();

        assertNotNull(actualList);
        assertEquals(actualList, writers);
    }

    @Test
    void getWriterById() {
        when(writerService.findWriterById(1L)).thenReturn(writer);

        Writer actualWriter = writerService.findWriterById(1L);

        assertNotNull(actualWriter);
        assertEquals(actualWriter.getId(), writer.getId());
        assertEquals(actualWriter.getFirstname(), writer.getFirstname());
        assertEquals(actualWriter.getLastname(), writer.getLastname());
    }

    @Test
    void createdNewWriter() {
        when(writerService.addNewWriter(writer)).thenReturn(writer);

        Writer actualWriter = writerService.addNewWriter(writer);

        assertNotNull(actualWriter);
        assertEquals(actualWriter.getId(), writer.getId());
        assertEquals(actualWriter.getFirstname(), writer.getFirstname());
        assertEquals(actualWriter.getLastname(), writer.getLastname());
    }

    @Test
    void updatedWriter() {
        when(writerService.updatedWriterById(1L, writer)).thenReturn(writer);

        Writer actualWriter = writerService.updatedWriterById(1L, writer);

        assertNotNull(actualWriter);
        assertEquals(actualWriter.getId(), writer.getId());
        assertEquals(actualWriter.getFirstname(), writer.getFirstname());
        assertEquals(actualWriter.getLastname(), writer.getLastname());
    }

    @Test
    void deleteWriter() {
        writerService.deletedWriterById(1L);
        verify(writerRepository, times(1)).deleteById(1L);
    }
}
