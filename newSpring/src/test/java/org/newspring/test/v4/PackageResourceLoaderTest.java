package org.newspring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.factory.support.PackageResourceLoader;
import org.litespring.core.io.Resource;

import java.io.IOException;

/**
 * Created by liyinyong on 2018/7/15.
 */
public class PackageResourceLoaderTest {
    @Test
    public void testGetResources() throws IOException {
        PackageResourceLoader loader = new PackageResourceLoader();
        Resource[] resources = loader.getResources("org.newspring.dao.V4");
        Assert.assertEquals(2, resources.length);
    }
}
