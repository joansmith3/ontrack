package net.ontrack.backend.dao.jdbc;

import net.ontrack.backend.dao.ValidationRunEventDao;
import net.ontrack.backend.dao.model.TValidationRunEvent;
import net.ontrack.backend.db.SQL;
import net.ontrack.backend.db.SQLUtils;
import net.ontrack.core.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ValidationRunEventJdbcDao extends AbstractJdbcDao implements ValidationRunEventDao {

    @Autowired
    public ValidationRunEventJdbcDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TValidationRunEvent> findByValidationRun(int validationRun, int offset, int count) {
        return getNamedParameterJdbcTemplate().query(
                SQL.VALIDATION_RUN_HISTORY,
                params("validationRun", validationRun).addValue("offset", offset).addValue("count", count),
                new RowMapper<TValidationRunEvent>() {
                    @Override
                    public TValidationRunEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new TValidationRunEvent(
                                SQLUtils.getEnum(Status.class, rs, "STATUS"),
                                rs.getString("CONTENT"),
                                rs.getString("AUTHOR"),
                                getInteger(rs, "AUTHOR_ID"),
                                SQLUtils.getDateTime(rs, "EVENT_TIMESTAMP")
                        );
                    }
                }
        );
    }
}