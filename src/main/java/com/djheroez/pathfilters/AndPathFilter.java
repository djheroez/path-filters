package com.djheroez.pathfilters;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AndPathFilter implements DirectoryStream.Filter<Path>
{
    private final List<DirectoryStream.Filter<Path>> pathFilters;

    public AndPathFilter()
    {
        this.pathFilters = new ArrayList<DirectoryStream.Filter<Path>>();
    }

    public void addPathFilter(DirectoryStream.Filter<Path> filter)
    {
        this.pathFilters.add(filter);
    }

    @Override
    public boolean accept(Path entry) throws IOException
    {
        if(this.pathFilters == null || this.pathFilters.isEmpty())
        {
            return false;
        }

        for(DirectoryStream.Filter<Path> filter : this.pathFilters)
        {
            if(!filter.accept(entry))
            {
                return false;
            }
        }
        return true;
    }
}