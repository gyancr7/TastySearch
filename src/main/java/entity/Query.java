package entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Query {

    public Set<String> queryTokens;

    public Query(List<String> queryTokensList) {
        Set<String> queryTokens = new HashSet<>();
        queryTokensList.replaceAll(String::toLowerCase);
        queryTokens.addAll(queryTokensList);
        this.queryTokens = queryTokens;
    }

}
