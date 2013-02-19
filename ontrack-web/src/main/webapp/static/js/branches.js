var Branches = function () {
	
	function createBranch (project) {
		Application.dialogAndSubmit({
			id: 'branch-create-dialog',
			title: loc('branch.create.title'),
			url: 'ui/manage/branch/' + project,
			successFn: function (data) {
				location = 'gui/branch/' + project + '/' + data.name;
			}
	    });
	}
	
	function deleteBranch (project,name) {
		Application.deleteEntity('branch/' + project, name, '');
	}
	
	function branchTemplate (project) {
	    return function (containerId, append, items) {
	        return Template.table(containerId, append, items, Template.tableRowLink('gui/branch/' + project));
	    };
	}
	
	return {
		createBranch: createBranch,
		deleteBranch: deleteBranch,
		branchTemplate: function (project) {
		    return Template.config({
		        url: 'ui/manage/branch/{0}/all'.format(project.html()),
		        render: Template.asTable(Template.asLink('gui/branch/{0}'.format(project.html()))),
		        placeholder: loc('branch.empty')
		    });
		}
	};
	
} ();