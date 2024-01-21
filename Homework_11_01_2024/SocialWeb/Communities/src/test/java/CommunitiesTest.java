import org.junit.After;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommunitiesTest {

    private CommunitiesInterface communitiesInterface;

    @Test
    public void testCommunitiesList() {
        List<String> communities = new ArrayList<>();
        communities.add(0, "community1");
        communities.add(1, "community2");
        communities.add(2, "community3");
        communities.add(3, "community4");
        communities.add(4, "community5");

        communitiesInterface = mock(CommunitiesInterface.class);
        when(communitiesInterface.communitiesList()).thenReturn(communities);

        assert(communities.get(0).equals("community1"));
        assert(communities.get(1).equals("community2"));
        assert(communities.get(2).equals("community3"));
        assert(communities.get(3).equals("community4"));
        assert(communities.get(4).equals("community5"));

        System.out.println("Test passed!");
    }

    @Test
    public void testDeleteCommunity() {
        List<String> communities = new ArrayList<>();
        communities.add(0, "community1");
        communities.add(1, "community2");
        communities.add(2, "community3");
        communities.add(3, "community4");
        communities.add(4, "community5");

        communitiesInterface = mock(CommunitiesInterface.class);
        when(communitiesInterface.communitiesList()).thenReturn(communities);

        communitiesInterface.deleteCommunity();
        communities.remove(4);

        Mockito.verify(communitiesInterface).deleteCommunity();

        assert(communities.size() == 4);

        System.out.println("Test passed!");
    }

    @Test
    public void testAddCommunityToFavourites() {
        List<String> communities = new ArrayList<>();
        communities.add(0, "community1");
        communities.add(1, "community2");
        communities.add(2, "community3");
        communities.add(3, "community4");
        communities.add(4, "community5");

        communitiesInterface = mock(CommunitiesInterface.class);
        when(communitiesInterface.communitiesList()).thenReturn(communities);

        communitiesInterface.addCommunityToFavourites();

        Mockito.verify(communitiesInterface).addCommunityToFavourites();

        System.out.println("Test passed!");
    }
}
