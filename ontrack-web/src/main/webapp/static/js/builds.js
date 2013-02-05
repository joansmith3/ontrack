var Builds = function () {
	
	function buildTemplate (project, branch) {
		return function (items) {
			return Template.links(items, 'gui/build/{0}/{1}'.format(project,branch));
		};
	}

	function buildValidationStampTemplate (project, branch) {
	    return function (items) {
            return Template.list(items, function (stamp) {
                var pClass;
                if (!stamp.run) {
                    pClass = 'validation-stamp-norun status-NONE';
                } else {
                    pClass = 'status-' + stamp.status;
                }
                var html = '<div class="{0}">'.format(pClass);
                html += '<img width="24" title="{2}" src="gui/validation_stamp/{0}/{1}/{2}/image" />'.format(
                    project.html(),
                    branch.html(),
                    stamp.name.html()
                    );
                html += ' <a href="gui/validation_stamp/{0}/{1}/{2}">{2}</a>'.format(project.html(), branch.html(), stamp.name.html());
                if (stamp.run) {
                    html += ' <p class="validation-run">';
                    html += '<a href="gui/validation_run/{0}"><i class="icon-play"></i> <span class="validation-run-status">{1}</span></a>'.format(stamp.runId, stamp.status.html());
                    html += ' <span class="validation-run-description">{0}</span>'.format(stamp.statusDescription.html());
                    html += '</p>';
                }
                html += '</div>';
                return html;
            });
        };
	}
	
	return {
		buildTemplate: buildTemplate,
		buildValidationStampTemplate: buildValidationStampTemplate
	};
	
} ();