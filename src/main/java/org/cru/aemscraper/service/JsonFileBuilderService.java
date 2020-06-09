package org.cru.aemscraper.service;

import org.cru.aemscraper.model.CloudSearchDocument;
import org.cru.aemscraper.model.PageData;

import java.util.Set;

public interface JsonFileBuilderService {
    void buildJsonFiles(Set<PageData> pageData, CloudSearchDocument.Type type);
}
