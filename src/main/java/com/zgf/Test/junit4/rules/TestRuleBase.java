package com.zgf.Test.junit4.rules;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class TestRuleBase {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void countsAssets() throws IOException {
//		File icon = tempFolder.newFile("icon.png");
		File assets = tempFolder.newFolder("assets");
		createAssets(assets, 3);
	}

	private void createAssets(File assets, int numberOfAssets) throws IOException {
		for (int index = 0; index < numberOfAssets; index++) {
			File asset = new File(assets, String.format("asset-%d.mpg", index));
			Assert.assertTrue("Asset couldn't be created.", asset.createNewFile());
		}
	}

}
