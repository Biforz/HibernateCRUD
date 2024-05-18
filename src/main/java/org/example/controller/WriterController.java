package org.example.controller;

import org.example.model.Writer;
import org.example.service.WriterService;

import java.util.List;

public class WriterController {
    private final WriterService writerService;

    public WriterController() {
        this.writerService = new WriterService();
    }

    public List<Writer> getAllWriter() {
        return writerService.findAllWriter();
    }

    public Writer getWriterById(Long id) {
        return writerService.findWriterById(id);
    }

    public Writer addNewWriter(Writer writer) {
        return writerService.addNewWriter(writer);
    }

    public Writer updatedWriterById(Long id, Writer writer) {
        return writerService.updatedWriterById(id, writer);
    }

    public void deletedWriterById(Long id) {
        writerService.deletedWriterById(id);
    }
}
