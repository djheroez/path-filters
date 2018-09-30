package com.djheroez.pathfilters;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class RegexPathFilter implements DirectoryStream.Filter<Path> {

    private final Pattern pattern;

    public RegexPathFilter(String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }

        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return pattern.matcher(entry.toString()).matches();
    }
}