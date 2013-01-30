var Projects = function () {
	
	function createProject () {
		Application.dialogAndSubmit(
			'project-create-dialog',
			loc('project.create.title'),
			'POST',
			'ui/manage/project',
			function (data) {
				Application.reload('projects');
				Application.reload('audit');
			});
	}
	
	function deleteProject (id) {
		Application.deleteEntity('project', id, '');
	}
	
	function projectTemplate (items) {
		return Template.links(items, 'gui/project');
	}
	
	return {
		createProject: createProject,
		deleteProject: deleteProject,
		projectTemplate: projectTemplate
	};
	
} ();