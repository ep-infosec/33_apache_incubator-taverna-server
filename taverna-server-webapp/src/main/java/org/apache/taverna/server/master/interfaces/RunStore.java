/*
 */
package org.apache.taverna.server.master.interfaces;
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

import java.util.Map;

import org.apache.taverna.server.master.exceptions.UnknownRunException;
import org.apache.taverna.server.master.utils.UsernamePrincipal;

/**
 * Interface to the mechanism that looks after the mapping of names to runs.
 * Instances of this class may also be responsible for enforcing timely cleanup
 * of expired workflows.
 * 
 * @author Donal Fellows.
 */
public interface RunStore {
	/**
	 * Obtain the workflow run for a given user and name.
	 * 
	 * @param user
	 *            Who wants to do the lookup.
	 * @param p
	 *            The general policy system context.
	 * @param uuid
	 *            The handle for the run.
	 * @return The workflow instance run.
	 * @throws UnknownRunException
	 *             If the lookup fails (either because it does not exist or
	 *             because it is not permitted for the user by the policy).
	 */
	TavernaRun getRun(UsernamePrincipal user, Policy p, String uuid)
			throws UnknownRunException;

	/**
	 * Obtain the named workflow run.
	 * 
	 * @param uuid
	 *            The handle for the run.
	 * @return The workflow instance run.
	 * @throws UnknownRunException
	 *             If the lookup fails (either because it does not exist or
	 *             because it is not permitted for the user by the policy).
	 */
	public TavernaRun getRun(String uuid) throws UnknownRunException;

	/**
	 * List the runs that a particular user may access.
	 * 
	 * @param user
	 *            Who wants to do the lookup, or <code>null</code> if it is
	 *            being done "by the system" when the full mapping should be
	 *            returned.
	 * @param p
	 *            The general policy system context.
	 * @return A mapping from run names to run instances.
	 */
	Map<String, TavernaRun> listRuns(UsernamePrincipal user, Policy p);

	/**
	 * Adds a workflow instance run to the store. Note that this operation is
	 * <i>not</i> expected to be security-checked; that is the callers'
	 * responsibility.
	 * 
	 * @param run
	 *            The run itself.
	 * @return The name of the run.
	 */
	String registerRun(TavernaRun run);

	/**
	 * Removes a run from the store. Note that this operation is <i>not</i>
	 * expected to be security-checked; that is the callers' responsibility.
	 * 
	 * @param uuid
	 *            The name of the run.
	 */
	void unregisterRun(String uuid);
}
