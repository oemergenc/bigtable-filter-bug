package bigtable.filter.bug;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public class BigTableContainer extends GenericContainer<BigTableContainer> {

    public static final Integer BIG_TABLE_PORT = 8086;

    public BigTableContainer() {
        super(DockerImageName.parse("google/cloud-sdk:322.0.0"));
        withExposedPorts(BIG_TABLE_PORT);
        withCommand("/bin/sh", "-c", "gcloud beta emulators bigtable start --host-port=0.0.0.0:" + BIG_TABLE_PORT);
    }
}
