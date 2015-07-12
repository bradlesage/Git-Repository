/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.xd.dirt.integration.bus.serializer.kryo;

import java.io.File;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * @author David Turanski
 */
public class FileCodec extends AbstractKryoCodec<File> {

	@Override
	protected void doSerialize(Kryo kryo, final File object, final Output output) {
		kryo.writeObject(output, object);
	}

	@Override
	protected File doDeserialize(Kryo kryo, final Input input) {
		File file = kryo.readObject(input, File.class);
		return new File(file.getPath());
	}

	protected void configureKryoInstance(Kryo kryo) {
		kryo.register(File.class, FILE_REGISTRATION_ID);
	}
}
