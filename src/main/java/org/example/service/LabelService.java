package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.example.repository.hibernate.HibernateLabelRepositoryImpl;

import java.util.List;

@RequiredArgsConstructor
public class LabelService {
    private final LabelRepository labelRepository;

    public LabelService() {
        this.labelRepository = new HibernateLabelRepositoryImpl();
    }

    public List<Label> findAllLabels() {
        return labelRepository.showAll();
    }

    public Label findById(Long id) {
        return labelRepository.showById(id);
    }

    public Label addNewLabel(Label label) {
        return labelRepository.add(label);
    }

    public Label updatedLabel(Long id, Label label) {
        return labelRepository.update(id, label);
    }

    public void deleteLabelById(Long id) {
        labelRepository.deleteById(id);
    }
}
