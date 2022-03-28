package designpatterns.structural.bridge;

/**
 * Structural Design Pattern
 * Used when both interfaces and implementations have hierarchies
 * & we want to hide implementation from client
 * For ex: 2 different remotes for 2 different TVs (LG & Phillips)
 * Class hierarchy : TV => LG & Phillips
 * Interface hierarchy : Remote => oldRemote & newRemote
 * Any TV can use any remote
 */

/**
 * Another Example:
 * Automobiles(abstract class) - Taxi and Bus
 * Workshop(interface) - Produce Workshop and Assemble Workshop
 */
public class BridgeClient {

    public static void main(String[] args) {
        Remote oldRemote = new OldRemote();
        Remote newRemote = new NewRemote();

        TV samsungTvOldRemote = new SamsungTv(oldRemote);
        samsungTvOldRemote.on();
        samsungTvOldRemote.off();

        TV samsungTvNewRemote = new SamsungTv(newRemote);
        samsungTvNewRemote.on();
        samsungTvNewRemote.off();

        TV phillipsTvOldRemote = new PhillipsTv(oldRemote);
        phillipsTvOldRemote.on();
        phillipsTvOldRemote.off();

        TV phillipsTvNewRemote = new PhillipsTv(newRemote);
        phillipsTvNewRemote.on();
        phillipsTvNewRemote.off();
    }

}
