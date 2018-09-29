package com.djheroez.pathfilters;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;

public class AgePathFilter implements DirectoryStream.Filter<Path>
{

    private long cutoff;
    private boolean acceptOlder;

    public AgePathFilter(long cutoff) {
        this(cutoff, true);
    }
    
    public AgePathFilter(long cutoff, boolean acceptOlder) {
        this.acceptOlder = acceptOlder;
        this.cutoff = cutoff;
    }

    @Override
    public boolean accept(Path entry) throws IOException
    {
        boolean newer = FileUtils.isFileNewer(entry.toFile(), this.cutoff);
        return acceptOlder ? !newer : newer;
    }
}
