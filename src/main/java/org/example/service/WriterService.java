package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Writer;
import org.example.repository.WriterRepository;
import org.example.repository.hibernate.HibernateWriterRepositoryImpl;

import java.util.List;

@RequiredArgsConstructor
public class WriterService {
    private final WriterRepository writerRepository;

    public WriterService() {
        this.writerRepository = new HibernateWriterRepositoryImpl();
    }

    public List<Writer> findAllWriter() {
        return writerRepository.showAll();
    }

    public Writer findWriterById(Long id) {
        return writerRepository.showById(id);
    }

    public Writer addNewWriter(Writer writer) {
        return writerRepository.add(writer);
    }

    public Writer updatedWriterById(Long id, Writer writer) {
        return writerRepository.update(id, writer);
    }

    public void deletedWriterById(Long id) {
        writerRepository.deleteById(id);
    }
}
