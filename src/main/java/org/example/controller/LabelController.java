package org.example.controller;

import org.example.model.Label;
import org.example.service.LabelService;

import java.util.List;

public class LabelController {
    private final LabelService labelService;

    public LabelController() {
        this.labelService = new LabelService();
    }

    public List<Label> getAllLabels() {
        return labelService.findAllLabels();
    }

    public Label getLabelById(Long id) {
        return labelService.findById(id);
    }

    public Label addNewLabel(Label label) {
        return labelService.addNewLabel(label);
    }

    public Label updatedLabelById(Long id, Label label) {
        return labelService.updatedLabel(id, label);
    }

    public void deletedLabelById(Long id) {
        labelService.deleteLabelById(id);
    }
}
