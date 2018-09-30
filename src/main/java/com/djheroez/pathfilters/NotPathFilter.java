package com.djheroez.pathfilters;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public class NotPathFilter implements DirectoryStream.Filter<Path> {
    private DirectoryStream.Filter<Path> filter;

    public NotPathFilter(final DirectoryStream.Filter<Path> filter) {
        this.filter = filter;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return !filter.accept(entry);
    }
}