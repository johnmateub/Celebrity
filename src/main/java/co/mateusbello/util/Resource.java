package co.mateusbello.util;

import java.util.List;

import co.mateusbello.exception.ResourceException;

public interface Resource {
    List<String> loadData() throws ResourceException;
}
