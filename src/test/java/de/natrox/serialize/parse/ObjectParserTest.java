/*
 * Copyright 2020-2022 NatroxMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.natrox.serialize.parse;

import de.natrox.serialize.exception.SerializeException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectParserTest {

    @Test
    void testObjectParser() throws SerializeException {
        Parser<TestObject> testObjectParser = ObjectParser.create(TestObject.class);

        TestObject object = testObjectParser.parse(Map.of("value", 42, "name", "Bob"));
        assertEquals(42, object.value);
        assertEquals("Bob", object.name);
    }

    private static class TestObject {
        private int value;
        private String name;
    }
}
