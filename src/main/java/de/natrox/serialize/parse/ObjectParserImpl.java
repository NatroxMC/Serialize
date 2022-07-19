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
import de.natrox.serialize.objectmapping.ObjectMapper;
import io.leangen.geantyref.GenericTypeReflector;
import io.leangen.geantyref.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@SuppressWarnings({"unchecked"})
final class ObjectParserImpl<T> implements ObjectParser<T> {

    private final Type type;
    private final ObjectMapper.Factory objectMapperFactory;

    ObjectParserImpl(Type type, ObjectMapper.Factory objectMapperFactory) {
        this.type = type;
        this.objectMapperFactory = objectMapperFactory;
    }

    @Override
    public @NotNull T parse(@NotNull Object obj) throws SerializeException {
        Type objType = TypeToken.get(obj.getClass()).getType();

        if (!GenericTypeReflector.isSuperType(Map.class, objType)) {
            throw new SerializeException(this.type, "Only map types are supported");
        }

        return (T) this.objectMapperFactory.get(type).load((Map<String, Object>) obj);
    }
}