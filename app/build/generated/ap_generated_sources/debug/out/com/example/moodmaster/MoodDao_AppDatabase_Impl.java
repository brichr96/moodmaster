package com.example.moodmaster;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MoodDao_AppDatabase_Impl implements MoodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Mood> __insertionAdapterOfMood;

  private final EntityDeletionOrUpdateAdapter<Mood> __deletionAdapterOfMood;

  public MoodDao_AppDatabase_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMood = new EntityInsertionAdapter<Mood>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `moods` (`moodID`,`mood`,`date`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Mood value) {
        stmt.bindLong(1, value.getMoodID());
        stmt.bindLong(2, value.getMood());
        final Long _tmp = Converters.dateToTimestamp(value.date);
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
      }
    };
    this.__deletionAdapterOfMood = new EntityDeletionOrUpdateAdapter<Mood>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `moods` WHERE `moodID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Mood value) {
        stmt.bindLong(1, value.getMoodID());
      }
    };
  }

  @Override
  public void insert(final Mood mood) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMood.insert(mood);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Mood mood) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMood.handle(mood);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Mood> getAllMoods() {
    final String _sql = "SELECT * FROM moods";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMoodID = CursorUtil.getColumnIndexOrThrow(_cursor, "moodID");
      final int _cursorIndexOfMood = CursorUtil.getColumnIndexOrThrow(_cursor, "mood");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final List<Mood> _result = new ArrayList<Mood>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Mood _item;
        final int _tmpMood;
        _tmpMood = _cursor.getInt(_cursorIndexOfMood);
        final Date _tmpDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDate);
        }
        _tmpDate = Converters.fromTimestamp(_tmp);
        _item = new Mood(_tmpMood,_tmpDate);
        final int _tmpMoodID;
        _tmpMoodID = _cursor.getInt(_cursorIndexOfMoodID);
        _item.setMoodID(_tmpMoodID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
