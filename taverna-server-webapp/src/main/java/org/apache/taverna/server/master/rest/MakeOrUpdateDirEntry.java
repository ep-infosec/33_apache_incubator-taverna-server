/*
 */
package org.apache.taverna.server.master.rest;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * The input to the REST interface for making directories and files, and
 * uploading file contents. Done with JAXB.
 * 
 * @author Donal Fellows
 */
@XmlRootElement(name = "filesystemOperation")
@XmlType(name = "FilesystemCreationOperation")
@XmlSeeAlso( { MakeOrUpdateDirEntry.MakeDirectory.class,
		MakeOrUpdateDirEntry.SetFileContents.class })
public abstract class MakeOrUpdateDirEntry {
	/**
	 * The name of the file or directory that the operation applies to.
	 */
	@XmlAttribute
	public String name;
	/**
	 * The contents of the file to upload.
	 */
	@XmlValue
	public byte[] contents;

	/**
	 * Create a directory, described with JAXB. Should leave the
	 * {@link MakeOrUpdateDirEntry#contents contents} field empty.
	 * 
	 * @author Donal Fellows
	 */
	@XmlRootElement(name = "mkdir")
	@XmlType(name = "MakeDirectory")
	public static class MakeDirectory extends MakeOrUpdateDirEntry {
	}

	/**
	 * Create a file or set its contents, described with JAXB.
	 * 
	 * @author Donal Fellows
	 */
	@XmlRootElement(name = "upload")
	@XmlType(name = "UploadFile")
	public static class SetFileContents extends MakeOrUpdateDirEntry {
	}
}
