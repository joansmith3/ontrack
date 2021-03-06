package net.ontrack.extension.svn.support;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;

public class SVNUtils {

    public static SVNURL toURL(String path) {
        try {
            return SVNURL.parseURIDecoded(path);
        } catch (SVNException e) {
            throw new IllegalArgumentException("Cannot get SVN URL for " + path, e);
        }
    }

    public static SVNURL toURL(String url, String path) {
        SVNURL repoURL = toURL(url);
        try {
            return repoURL.setPath(path, false);
        } catch (SVNException e) {
            throw new IllegalArgumentException("Cannot get SVN URL for " + path, e);
        }

    }
}
